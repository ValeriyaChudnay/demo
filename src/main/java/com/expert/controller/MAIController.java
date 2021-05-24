package com.expert.controller;

import com.expert.entity.*;
import com.expert.service.ExpertService;
import com.expert.service.ProjectService;
import com.expert.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MAIController {


    public static final String EXPERT = "expert";
    public static final String DELFI_DATA = "delfiData";
    public static final String MAI = "mai";
    private final ExpertService expertService;
    private final ProjectService projectService;
    private final QuestionService questionService;


    @Autowired
    public MAIController(ExpertService expertService, ProjectService projectService, QuestionService questionService) {
        this.expertService = expertService;
        this.projectService = projectService;
        this.questionService = questionService;
    }

    @GetMapping("/createMAI")
    public String createMAI(@RequestParam("criteria") int criteria, @RequestParam("alternate") int alternate, HttpSession session) {
        MAI mai = new MAI();
        mai.setCriteria(new double[criteria][criteria]);
        List<Criteria> criteriaList = new ArrayList<>();
        for(int i=0;i<criteria;i++){
            Criteria c = new Criteria();
            c.setAlternates(new double[alternate][alternate]);
            criteriaList.add(c);
        }
        mai.setAlterantes(criteriaList);
        mai.setAlternate(alternate);
        session.setAttribute(MAI,mai);
        return "maiTables";
    }
    @PostMapping("/doMAI")
    public String doMAI(@RequestParam Map<String,String> params, HttpSession session) {
        MAI mai = (com.expert.entity.MAI) session.getAttribute(MAI);
        int criLength = mai.getCriteria().length;
        String[] criNames= new String[criLength];
        for(int i = 1; i<= criLength; i++ ){
            criNames[i-1]=params.get("criName"+i);
        }
        mai.setCriteriaName(criNames);

        int altLength = mai.getAlternate();
        String[] altNames= new String[altLength];
        for(int i = 1; i<= altLength; i++ ){
            altNames[i-1]=params.get("altName"+i);
        }
        mai.setAlternameName(altNames);

        double[][] crit = mai.getCriteria();
        List<Criteria> alternates = new ArrayList<>();
        for(int i=0;i<criLength;i++){
            for(int j=0;j<criLength;j++){
                crit[i][j]= Double.parseDouble(params.get("cri_id="+i+":"+j));
            }
            Criteria c=new Criteria();
            double[][] alt = new double[altLength][altLength];
            for(int a=0;a<altLength;a++){
                for(int b=0;b<altLength;b++){
                alt[a][b]= Double.parseDouble(params.get("alt"+(i+1)+"_id="+a+":"+b));
                }
            }
            c.setAlternates(alt);
            alternates.add(c);
        }

        mai.setAlterantes(alternates);
        mai.setCriteria(crit);
        countWparam(mai);

        double[] result=countResult(mai);
        session.setAttribute("result",result);
        return "MAIResult";
    }

    private double[] countResult(MAI mai) {
        int altLength = mai.getAlternate();
        int criLength = mai.getCriteria().length;
        double[] result=new double[altLength];
        for(int i=0;i<altLength;i++){
            double sum = 0;
            int j =0;
            for (Criteria alterante : mai.getAlterantes()) {
                sum+=mai.getwCriteria()[j]*alterante.getpVal()[i];
                j++;
            }
            result[i]=sum;
        }
        return result;
    }

    private void countWparam(MAI mai) {
        mai.setwCriteria(countWCrit(mai.getCriteria()));
        for (Criteria alterante : mai.getAlterantes()) {
            alterante.setpVal(countWCrit(alterante.getAlternates()));
        }
    }

    private double[] countWCrit(double[][] criteria) {
        double[] res = new double[criteria.length];
        double sum = 0;
        for(int i=0;i<res.length;i++){
            double mult=1;
            for(int j=0;j<res.length;j++){
                mult=mult*criteria[i][j];
            }
            res[i]=Math.pow(mult,1d/res.length);
            sum+=res[i];
        }
        for(int i=0;i<res.length;i++){
            res[i]=res[i]/sum;
        }

        return res;
    }


    private static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

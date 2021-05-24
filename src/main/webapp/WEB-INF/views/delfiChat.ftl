<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
     <script>
     var stompClient = null;

     function setConnected(connected) {
         $("#connect").prop("disabled", connected);
         $("#disconnect").prop("disabled", !connected);
         if (connected) {
             $("#conversation").show();
         }
         else {
             $("#conversation").hide();
         }
         $("#greetings").html("");
     }

     function connect() {
         var socket = new SockJS('/gs-guide-websocket');
         stompClient = Stomp.over(socket);

         stompClient.connect({}, function (frame) {
             setConnected(true);
             console.log('Connected: ' + frame);
             stompClient.subscribe('/topic/greetings', function (greeting) {
                 showGreeting(JSON.parse(greeting.body).content);
             });
         });
     }

     function disconnect() {
         if (stompClient !== null) {
             stompClient.disconnect();
         }
         setConnected(false);
         console.log("Disconnected");
     }

     function sendName() {
         stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
     }

     function showGreeting(message) {
         $("#greetings").append("<tr><td>" + message + "</td></tr>");
     }

     $(function () {
         $("#chatForm").on('submit', function (e) {
             e.preventDefault();
         });
         $("#chatForm1").on('submit', function (e) {
                      e.preventDefault();
                  });
         $( "#connect" ).click(function() { connect(); });
         $( "#disconnect" ).click(function() { disconnect(); });
         $( "#send" ).click(function() { sendName(); });
     });
     </script>
</head>
<body>
<#include "header.ftl">
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form id="chatForm" class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
          <#if isAdmin>
         <div class="col-md-6">
        <form action="/endDelfiChat" method="get">
            <div >
                <label>Question number in anketa:</label>
                <input type="number" value="10" name="questionNumber">
            </div>
            <button class="btn btn-dark" type="submit">Create</button>
        </form>
           </div>
           </br>
           </br>
             </#if>
        <div class="col-md-6">
            <form id="chatForm1" class="form-inline">
                <div class="form-group">
                    <label for="name">Pass you message here:</label>
                    <input type="text" id="name" class="form-control" placeholder="Message here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
     </br>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Delfi Chat</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
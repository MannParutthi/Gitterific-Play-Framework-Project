$ ->
  ws = new WebSocket $("body").data("ws-url")
  console.log "check here please ===>> "
  ws.onmessage = (event) ->
   	$('#time').empty()
    message = JSON.parse event.data

    dList = $("<div>")
    for i of message
    	u = $("<h1>").text("User: " + message[i].user).append("</h1> <br/>")
    	r = $("<h1>").text("Repo: " + message[i].repo).append("</h1> <br/>")
    	t = $("<h1>").text("Topics: " + message[i].topics).append("</h1> <br/>")
    	dList.append(u).append(r).append(t)
    	
    $('#time').append(dList).append("</div>").append("<br/>").append("<br/>")

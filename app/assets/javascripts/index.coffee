$ ->
  ws = new WebSocket $("body").data("ws-url")
  console.log "check here please ===>> "
  ws.onmessage = (event) ->
   	$('#time').empty()
    message = JSON.parse event.data

    dList = $("<div>")
    for i of message
    	u = $("<h1>").text("User: ").append("<a href='http://localhost:9000/userData/" + message[i].user + "'>" + message[i].user + "</a>").append("</h1> <br/>")
    	r = $("<h1>").text("Repo: ").append("<a href='http://localhost:9000/repoData/" + message[i].user + "/" + message[i].repo + "'>" + message[i].repo + "</a>").append("</h1> <br/>")
    	t = $("<h1>").text("Topics: ").append("<a>" + message[i].topics + "</a>").append("</h1> <br/>")
    	dList.append(u).append(r).append(t).append("<br/>")
    	
    $('#time').append(dList).append("</div>").append("<br/>").append("<br/>")

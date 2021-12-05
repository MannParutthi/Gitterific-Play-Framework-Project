$ ->
  ws = new WebSocket $("body").data("ws-url")
  console.log "check here pleasee ===>> "
  ws.onmessage = (event) ->
    message = JSON.parse event.data
    console.log "inside ==> " + message.time
    $('#time').append message.time + "<br/>"
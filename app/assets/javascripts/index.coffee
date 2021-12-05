$ ->
  ws = new WebSocket $("body").data("ws-url")
  console.log "check here pleasee ===>> "
  ws.onmessage = (event) ->
    message = JSON.parse event.data
    console.log "inside ==> " + message
    $('#time').append message + "<br/>"
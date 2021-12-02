$ ->
  ws = new WebSocket $("body").data("ws-url")
  ws.onmessage = (event) ->
    updatedData = JSON.parse event.data
    console.log "chk here ==> " + updatedData
    $('#time').append "abcd" + "<br/>"
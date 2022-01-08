$ ->
    ws = undefined
    ws = new WebSocket($('body').data('ws-url'))

    ws.onmessage = (event) ->
      dList = undefined
      i = undefined
      j = undefined
      message = undefined
      r = undefined
      t = undefined
      topicList = undefined
      u = undefined
      message = JSON.parse(event.data)
      dList = $('<div>')
      for i of message
        `i = i`
        u = $('<h1 style="display: inline-block">').text('User: ').append('<a href=\'/userData/' + message[i].user + '\'>' + message[i].user + '</a>').append('</h1>' + ' /')
        r = $('<h1 style="display: inline-block">').text('Repo: ').append('<a href=\'/repoData/' + message[i].user + '/' + message[i].repo + '\'>' + message[i].repo + '</a>').append('</h1>')
        t = $('<h1>').text('Topics: ')
        topicList = message[i].topics.split(',')
        j = 0
        while j < topicList.length - 1
          t.append('<a href=\'/topicData/' + topicList[j] + '\'>' + topicList[j] + '</a>').append ','
          j++
        dList.append(u).append(r).append(t).append('</h1> <br/>').append
      dList.append('</div>').append('<br/>').append '<br/>'
      $('#time').html dList
      
      $('#ele0').hide()
<html>
<head>
  <title>Random Quote</title>
  <g:javascript library="jquery"/>
</head>

<body>
<feature:enabled feature="randomQuote">
  <div id="quote">
    <q>${quote.content}</q>

    <p>${quote.author}</p>
  </div>
</feature:enabled>
<feature:enabled feature="ajaxQuote">
  <ul id="menu">
    <li><g:remoteLink action="ajaxRandom" update="quote">
      Next Quote
    </g:remoteLink>
    </li>
    <li><g:link action="list">
      Admin
    </g:link>
    </li>
  </ul>
</feature:enabled>
</body>
</html>
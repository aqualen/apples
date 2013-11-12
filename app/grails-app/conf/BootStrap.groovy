class BootStrap {

  def init = { servletContext ->
    // Since our console doesn't work... add some quotes here.
    new com.ljs.apples.Quote(author: 'Chuck Norris Facts',
                             content: 'Chuck Norris always uses his own design patterns, and his favorite is the Roundhouse Kick').save()
    new com.ljs.apples.Quote(author: 'Eric Raymond',
                             content: 'Being a social outcast helps you stay concentrated on the really important things, like thinking and hacking.').save()
  }
  def destroy = {
  }
}

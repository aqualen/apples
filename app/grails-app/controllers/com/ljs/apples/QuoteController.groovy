package com.ljs.apples

class QuoteController {

  static scaffold = true

  def quoteService

  def random = {
    def randomQuote = quoteService.getRandomQuote()
    [quote: randomQuote]
  }

  def ajaxRandom() {
    def randomQuote = quoteService.getRandomQuote()
    render {
      q(randomQuote.content)
      p(randomQuote.author)
    }
  }
}

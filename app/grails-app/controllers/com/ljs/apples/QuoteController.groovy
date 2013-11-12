package com.ljs.apples

class QuoteController {

  static scaffold = true

  def quoteService

  def random = {
    def randomQuote = quoteService.getRandomQuote()
    [quote: randomQuote]
  }
}

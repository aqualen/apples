package com.ljs.apples

class QuoteController {

  static scaffold = true

  //  static {
  //    withoutFeature('quoteScaffold') {
  //      scaffold = false
  //    }
  //  }

  def index() {
    //    withFeature('quote') {
    //      redirect(action: "home")
    //    }
  }

  def home() {
    // http://localhost:8090/app/quote/home
    withFeature('quote') {
      render "<h1>Some day, something interesting will be here!</h1>"
    }
    withoutFeature('quote') {
      render "<h1>Stay tuned, good stuff coming soon!</h1>"
    }
  }

  def random() {
    withFeature('randomQuote') {
      def allQuotes = Quote.list()
      def randomQuote
      if (allQuotes.size() > 0) {
        def randomIdx = new Random().nextInt(allQuotes.size())
        randomQuote = allQuotes[randomIdx]
      } else {
        randomQuote = new Quote(author: "Anonymous",
                                content: "Real Programmers Don't eat Quiche")
      }
      [quote: randomQuote]
    }
  }
}

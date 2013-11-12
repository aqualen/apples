package com.ljs.apples

import grails.transaction.Transactional

@Transactional
class QuoteService {

  def getStaticQuote() {
    return new Quote(author: "Aqualen",
                     content: "Real Programmers make great quiche")
  }

  def getRandomQuote() {
    def randomQuote

    withFeature('randomQuote') {
      def allQuotes = Quote.list()
      if (allQuotes.size() > 0) {
        def randomIdx = new Random().nextInt(allQuotes.size())
        randomQuote = allQuotes[randomIdx]
      } else {
        randomQuote = getStaticQuote()
      }
    }
    return randomQuote
  }
}

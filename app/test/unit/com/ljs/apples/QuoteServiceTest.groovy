package com.ljs.apples

import grails.test.mixin.TestFor

@TestFor(QuoteService)
class QuoteServiceTest {

  void testStaticQuoteReturnsQuicheQuote() {
    Quote staticQuote = service.getStaticQuote()
    assert staticQuote.author == "Aqualen"
    assert staticQuote.content.startsWith("Real")
  }

}

package com.ljs.apples

class QuoteController {

  def index() {
    withFeature('quote') {
      redirect(action: "home")
    }
  }

  def home() {  // http://localhost:8090/app/quote/home
    withFeature('quote') {
      render "<h1>Some day, something interesting will be here!</h1>"
    }
    withoutFeature('quote') {
      render "<h1>Stay tuned, good stuff coming soon!</h1>"
    }
  }

  def random() {
    withFeature('randomQuote'){
      def staticAuthor = "Anonymous"
      def staticContent = "Real Programmers make exquisite quiche"
      [author: staticAuthor, content: staticContent]
    }
  }
}

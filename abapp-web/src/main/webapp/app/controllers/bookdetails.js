import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {

    onUpdateButtonClick(book) {

      var self = this;

      function transitionToBooks() {
        console.log('transition to route...');
        self.transitionToRoute('books');
      }

      function failure(reason) {
        console.log(reason);
      }

      // console.log(student.get('name'));
      console.log(book);
      book.save().then(transitionToBooks).catch(failure);
    },

    onInputBlur(event){
      var book = this.get('model.book');
      var property = event.target.name;
      var value = event.target.value;
      book.set(property, value);
    },

    onChangeAuthorButtonClick(){
      var availableAuthorsElement = document.getElementById('availableAuthors');
      var authorId = availableAuthorsElement.options[availableAuthorsElement.selectedIndex].value;

      var author = this.store.peekRecord('author', authorId);
      var selectedAuthors = this.get('model.book.author');
      selectedAuthors=author;

    },
  }
});

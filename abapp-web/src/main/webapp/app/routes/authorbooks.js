import Ember from 'ember';

export default Ember.Route.extend({
  model(params){
    return Ember.RSVP.hash({
      books2: this.store.find('book',params.author_id),
      books: this.store.findAll('book'),
      author: this.store.peekRecord('author', params.author_id)
    });
  }
});

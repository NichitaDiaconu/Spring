import Ember from 'ember';

export default Ember.Route.extend({
  model(){
    return Ember.RSVP.hash({
      books: this.store.findAll('book'),
      authors: this.store.findAll('author')
    });
  }
});

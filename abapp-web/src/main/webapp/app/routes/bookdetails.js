import Ember from 'ember';

export default Ember.Route.extend({
  model(params) {
    // return this.store.peekRecord('student',params.student_id);
    return Ember.RSVP.hash({
      book: this.store.peekRecord('book',params.book_id),
      authors: this.store.findAll('author'),
    });
  }
});

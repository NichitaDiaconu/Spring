import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('authors', function() {
    this.route('new');
  });
  this.route('authorbooks', {path: '/authorbooks/:author_id'});
  this.route('books');
  this.route('bookdetails',  {path: '/bookdetails/:book_id'});
});

export default Router;

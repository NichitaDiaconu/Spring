import DS from 'ember-data';

export default DS.Model.extend({
  title: DS.attr(),
  isbn: DS.attr(),
  year: DS.attr(),
  author: DS.belongsTo('author')
});

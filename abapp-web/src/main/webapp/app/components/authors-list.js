import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    onDeleteButtonClick(authorId){
      console.log("delete button clicked...", authorId);

      this.get('onDelete')(authorId);

    }
  }
});

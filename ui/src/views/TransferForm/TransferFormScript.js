import { SCHEDULE_ENDPOINT } from "../../utils/constants.js"

export default {
  data() {
    return {
      transfer: {
        sourceAccount: '',
        destinationAccount: '',
        amount: null,
        transferDate: ''
      }
    };
  },
  methods: {
    scheduleTransfer() {
      fetch(SCHEDULE_ENDPOINT, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.transfer)
      })
      .then(response => {
        if (response.ok) {
          alert('Transfer scheduled successfully!');
          this.resetForm();
        } else {
          alert('Failed to schedule transfer.');
        }
      })
      .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while scheduling transfer.');
      });
    },
    resetForm() {
      this.transfer = {
        sourceAccount: '',
        destinationAccount: '',
        amount: null,
        transferDate: ''
      };
    }
  }
};
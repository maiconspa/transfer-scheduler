import { createRouter, createMemoryHistory } from 'vue-router';
import TransferForm from '../views/TransferForm/TransferForm.vue';
import NotFound from '../views/NotFound/NotFound.vue';


const routes = [
  {
    path: '/',
    name: 'schedule',
    component: TransferForm
  },
  {
    path: '/:catchAll(.*)',
    component: NotFound
  }
];

const router = createRouter({
  history: createMemoryHistory(),
  routes
});

export default router;

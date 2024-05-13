<template>
    <div>
      <h2>Agendar Transferência</h2>
      <form @submit.prevent="scheduleTransfer">
        <div>
          <label for="sourceAccount">Conta de Origem:</label>
          <input type="text" id="sourceAccount" v-model="transfer.sourceAccount" required>
        </div>
        <div>
          <label for="destinationAccount">Conta de Destino:</label>
          <input type="text" id="destinationAccount" v-model="transfer.destinationAccount" required>
        </div>
        <div>
          <label for="amount">Valor da Transferência:</label>
          <input type="number" id="amount" v-model="transfer.amount" required>
        </div>
        <div>
          <label for="transferDate">Data da Transferência:</label>
          <input type="date" id="transferDate" v-model="transfer.transferDate" required>
        </div>
        <button type="submit">Agendar</button>
      </form>
    </div>
  </template>
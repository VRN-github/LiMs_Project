const express = require('express');
const router = express.Router();
const { Client } = require('../../models');

router.get('/', async (req, res) => {
  try {
    const clients = await Client.findAll();
    res.json(clients);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;

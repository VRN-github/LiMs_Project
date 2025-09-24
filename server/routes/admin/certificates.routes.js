const express = require('express');
const router = express.Router();
const { Certificate, Client } = require('../../models');

router.get('/', async (req, res) => {
  try {
    const certificates = await Certificate.findAll({ include: Client });
    res.json(certificates);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;

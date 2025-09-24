const express = require('express');
const router = express.Router();
const { MasterRenewal, Renewal } = require('../../models');

router.get('/', async (req, res) => {
  try {
    const masterRenewals = await MasterRenewal.findAll({ include: Renewal });
    res.json(masterRenewals);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;

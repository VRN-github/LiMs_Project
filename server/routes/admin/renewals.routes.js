const express = require('express');
const router = express.Router();
const { Renewal, Certificate } = require('../../models');

router.get('/', async (req, res) => {
  try {
    const renewals = await Renewal.findAll({ include: Certificate });
    res.json(renewals);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;

const Client = require('./client')(sequelize, Sequelize.DataTypes);
const Certificate = require('./certificate')(sequelize, Sequelize.DataTypes);
const Renewal = require('./renewal')(sequelize, Sequelize.DataTypes);
const MasterRenewal = require('./masterRenewal')(sequelize, Sequelize.DataTypes);

const db = {
  Client,
  Certificate,
  Renewal,
  MasterRenewal
};

// Setup associations
Object.values(db).forEach(model => {
  if (model.associate) model.associate(db);
});

module.exports = db;

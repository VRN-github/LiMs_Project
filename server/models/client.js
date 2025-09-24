module.exports = (sequelize, DataTypes) => {
  const Client = sequelize.define('Client', {
    name: { type: DataTypes.STRING, allowNull: false },
    organization: DataTypes.STRING,
    email: DataTypes.STRING,
    phone: DataTypes.STRING,
    status: { type: DataTypes.STRING, defaultValue: 'active' },
    created_at: { type: DataTypes.DATE, defaultValue: DataTypes.NOW }
  }, {
    tableName: 'clients',
    timestamps: false
  });

  Client.associate = models => {
    Client.hasMany(models.Certificate, { foreignKey: 'client_id' });
  };

  return Client;
};

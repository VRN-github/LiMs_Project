module.exports = (sequelize, DataTypes) => {
  const Renewal = sequelize.define('Renewal', {
    renewal_date: { type: DataTypes.DATE, allowNull: false },
    status: { type: DataTypes.STRING, defaultValue: 'pending' },
    remarks: DataTypes.STRING
  }, {
    tableName: 'renewals',
    timestamps: false
  });

  Renewal.associate = models => {
    Renewal.belongsTo(models.Certificate, { foreignKey: 'certificate_id' });
    Renewal.belongsToMany(models.MasterRenewal, {
      through: 'master_renewal_items',
      foreignKey: 'renewal_id',
      otherKey: 'master_renewal_id'
    });
  };

  return Renewal;
};

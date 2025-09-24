module.exports = (sequelize, DataTypes) => {
  const MasterRenewal = sequelize.define('MasterRenewal', {
    batch_date: { type: DataTypes.DATE, defaultValue: DataTypes.NOW },
    status: { type: DataTypes.STRING, defaultValue: 'initiated' },
    notes: DataTypes.STRING
  }, {
    tableName: 'master_renewals',
    timestamps: false
  });

  MasterRenewal.associate = models => {
    MasterRenewal.belongsToMany(models.Renewal, {
      through: 'master_renewal_items',
      foreignKey: 'master_renewal_id',
      otherKey: 'renewal_id'
    });
  };

  return MasterRenewal;
};

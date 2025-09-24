module.exports = (sequelize, DataTypes) => {
  const Certificate = sequelize.define('Certificate', {
    certificate_type: DataTypes.STRING,
    issued_date: DataTypes.DATE,
    expiry_date: DataTypes.DATE,
    status: { type: DataTypes.STRING, defaultValue: 'valid' },
    file_url: DataTypes.STRING
  }, {
    tableName: 'certificates',
    timestamps: false
  });

  Certificate.associate = models => {
    Certificate.belongsTo(models.Client, { foreignKey: 'client_id' });
    Certificate.hasMany(models.Renewal, { foreignKey: 'certificate_id' });
  };

  return Certificate;
};

const clientsRoutes = require('./routes/admin/clients.routes');
const certificatesRoutes = require('./routes/admin/certificates.routes');
const renewalsRoutes = require('./routes/admin/renewals.routes');
const masterRenewalsRoutes = require('./routes/admin/masterRenewals.routes');

app.use('/api/admin/clients', clientsRoutes);
app.use('/api/admin/certificates', certificatesRoutes);
app.use('/api/admin/renewals', renewalsRoutes);
app.use('/api/admin/master-renewals', masterRenewalsRoutes);

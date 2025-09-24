-- Clients Table
CREATE TABLE IF NOT EXISTS clients (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  organization TEXT,
  email TEXT,
  phone TEXT,
  status TEXT DEFAULT 'active',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Certificates Table
CREATE TABLE IF NOT EXISTS certificates (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  client_id INTEGER NOT NULL,
  certificate_type TEXT,
  issued_date DATE,
  expiry_date DATE,
  status TEXT DEFAULT 'valid',
  file_url TEXT,
  FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Renewals Table
CREATE TABLE IF NOT EXISTS renewals (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  certificate_id INTEGER NOT NULL,
  renewal_date DATE NOT NULL,
  status TEXT DEFAULT 'pending',
  remarks TEXT,
  FOREIGN KEY (certificate_id) REFERENCES certificates(id)
);

-- Master Renewals Table
CREATE TABLE IF NOT EXISTS master_renewals (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  batch_date DATE DEFAULT CURRENT_DATE,
  status TEXT DEFAULT 'initiated',
  notes TEXT
);

-- Join Table: MasterRenewal ↔ Renewals
CREATE TABLE IF NOT EXISTS master_renewal_items (
  master_renewal_id INTEGER NOT NULL,
  renewal_id INTEGER NOT NULL,
  PRIMARY KEY (master_renewal_id, renewal_id),
  FOREIGN KEY (master_renewal_id) REFERENCES master_renewals(id),
  FOREIGN KEY (renewal_id) REFERENCES renewals(id)
);

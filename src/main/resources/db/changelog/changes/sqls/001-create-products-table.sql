CREATE SEQUENCE IF NOT EXISTS products_pro_id_seq
      INCREMENT 1
       MINVALUE 1
       MAXVALUE 9223372036854775807
          START 1
          CACHE 1;

CREATE TABLE IF NOT EXISTS products (
    pro_id             BIGINT           NOT NULL DEFAULT NEXTVAL('products_pro_id_seq'::REGCLASS),
    pro_name           VARCHAR(255)     NOT NULL,
    pro_type           SMALLINT         NOT NULL,
    pro_price          NUMERIC(10, 2)   NOT NULL,
    pro_stock_quantity INTEGER          NULL,
    pro_active         BOOLEAN          NOT NULL DEFAULT TRUE,
    pro_metadata       JSONB            NULL,

    CONSTRAINT pk_products PRIMARY KEY(pro_id)
);


INSERT INTO products (
    pro_name,
    pro_type,
    pro_price,
    pro_stock_quantity,
    pro_active,
    pro_metadata
) VALUES

-- =========================================
-- 1 - PHYSICAL
-- =========================================
(
    'Livro Clean Code',
    1,
    129.90,
    15,
    TRUE,
    '{
        "category": "books",
        "sku": "BOOK-001",
        "delivery_days_min": 5,
        "delivery_days_max": 10
    }'::jsonb
),

(
    'Notebook Gamer RTX',
    1,
    8999.90,
    3,
    TRUE,
    '{
        "category": "electronics",
        "sku": "ELEC-001",
        "low_stock_alert": true,
        "delivery_days_min": 7,
        "delivery_days_max": 10
    }'::jsonb
),

(
    'Camiseta Premium',
    1,
    79.90,
    50,
    TRUE,
    '{
        "category": "clothing",
        "sku": "CLOTH-001",
        "sizes": ["P", "M", "G", "GG"]
    }'::jsonb
),

-- =========================================
-- 2 - SUBSCRIPTION
-- =========================================
(
    'Streaming Premium Mensal',
    2,
    39.90,
    NULL,
    TRUE,
    '{
        "plan": "premium",
        "billing_cycle": "monthly",
        "max_active_per_customer": 1,
        "compatible_with": ["family"]
    }'::jsonb
),

(
    'SaaS Gestão Empresarial',
    2,
    299.90,
    NULL,
    TRUE,
    '{
        "plan": "business",
        "billing_cycle": "monthly",
        "max_active_per_customer": 5
    }'::jsonb
),

(
    'Academia Online',
    2,
    59.90,
    NULL,
    TRUE,
    '{
        "plan": "fitness",
        "billing_cycle": "yearly",
        "trial_days": 7
    }'::jsonb
),

-- =========================================
-- 3 - DIGITAL
-- =========================================
(
    'Curso Java Completo',
    3,
    199.90,
    NULL,
    TRUE,
    '{
        "license_limit": 1000,
        "delivery_method": "email",
        "license_type": "single-user"
    }'::jsonb
),

(
    'E-book Arquitetura de Software',
    3,
    49.90,
    NULL,
    TRUE,
    '{
        "license_limit": 5000,
        "format": "pdf",
        "delivery_method": "download"
    }'::jsonb
),

(
    'Software ERP Desktop',
    3,
    1499.90,
    NULL,
    TRUE,
    '{
        "license_limit": 200,
        "activation_required": true,
        "platform": "windows"
    }'::jsonb
),

-- =========================================
-- 4 - PRE_ORDER
-- =========================================
(
    'PlayStation 6 - Pré-venda',
    4,
    6499.90,
    NULL,
    TRUE,
    '{
        "release_date": "2026-12-15",
        "pre_order_limit": 1000,
        "pre_order_discount_percent": 10,
        "cancelation_deadline_days": 7
    }'::jsonb
),

(
    'Livro Java 25 - Pré-venda',
    4,
    159.90,
    NULL,
    TRUE,
    '{
        "release_date": "2026-08-01",
        "pre_order_limit": 500,
        "pre_order_discount_percent": 5
    }'::jsonb
),

(
    'Novo Smartphone Ultra X',
    4,
    4999.90,
    NULL,
    TRUE,
    '{
        "release_date": "2026-11-20",
        "pre_order_limit": 2000,
        "pre_order_discount_percent": 8
    }'::jsonb
),

-- =========================================
-- 5 - CORPORATE
-- =========================================
(
    'Pacote 100 Notebooks Corporativos',
    5,
    450000.00,
    120,
    TRUE,
    '{
        "bulk_discount_percent": 15,
        "approval_required_above": 50000,
        "payment_terms_days": [30, 60, 90],
        "requires_cnpj_validation": true
    }'::jsonb
),

(
    'Licença Office Empresarial',
    5,
    75000.00,
    NULL,
    TRUE,
    '{
        "bulk_discount_percent": 10,
        "approval_required_above": 50000,
        "payment_terms_days": [30, 60],
        "requires_cnpj_validation": true
    }'::jsonb
),

(
    'Suprimentos Corporativos',
    5,
    12000.00,
    500,
    TRUE,
    '{
        "bulk_discount_percent": 5,
        "payment_terms_days": [30],
        "requires_cnpj_validation": true
    }'::jsonb
);
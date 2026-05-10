CREATE SEQUENCE IF NOT EXISTS orders_ord_id_seq
      INCREMENT 1
       MINVALUE 1
       MAXVALUE 9223372036854775807
          START 1
          CACHE 1;

CREATE TABLE IF NOT EXISTS orders (
    ord_id             BIGINT           NOT NULL DEFAULT NEXTVAL('orders_ord_id_seq'::REGCLASS),
    ord_customer_id    INTEGER          NOT NULL,
    ord_status         SMALLINT         NOT NULL,
    ord_total_amount   NUMERIC(12, 2)   NOT NULL,
    ord_failure_reason VARCHAR(255)     NULL,
    ord_created_at     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ord_updated_at     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_orders PRIMARY KEY(ord_id)
);
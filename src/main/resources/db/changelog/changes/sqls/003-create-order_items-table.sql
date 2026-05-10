CREATE SEQUENCE IF NOT EXISTS order_items_oit_id_seq
      INCREMENT 1
       MINVALUE 1
       MAXVALUE 9223372036854775807
          START 1
          CACHE 1;

CREATE TABLE IF NOT EXISTS order_items (
    oit_id             BIGINT           NOT NULL DEFAULT NEXTVAL('order_items_oit_id_seq'::REGCLASS),
    oit_order_id       BIGINT           NOT NULL,
    oit_product_id     BIGINT           NOT NULL,
    oit_quantity       INTEGER          NOT NULL,
    oit_unit_price     NUMERIC(12, 2)   NOT NULL,
    oit_metadata       TEXT             NULL,

    CONSTRAINT pk_order_items PRIMARY KEY(oit_id),
    CONSTRAINT fk_order FOREIGN KEY(oit_order_id) REFERENCES orders(ord_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_product FOREIGN KEY(oit_product_id) REFERENCES products(pro_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
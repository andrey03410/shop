CREATE TABLE cake
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255),
    calories DECIMAL,
    image    VARCHAR(255),
    price    DECIMAL,
    weight   DECIMAL,
    CONSTRAINT pk_cake PRIMARY KEY (id)
);
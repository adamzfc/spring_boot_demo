CREATE TABLE IF NOT EXISTS USER (
  `ID`         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `username`   VARCHAR(30) NOT NULL,
  `password`   VARCHAR(30) NOT NULL,
  `salt`       VARCHAR(30) NOT NULL,
  `email`      VARCHAR(30) NOT NULL,
  `disabled`   BOOL        NOT NULL DEFAULT FALSE,
  `createTime` DATETIME    NOT NULL,
  `lastTime`   DATETIME             DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE IF NOT EXISTS ROLE (
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(30) NOT NULL,
  `description` VARCHAR(50)          DEFAULT NULL,
  `disabled`    BOOL        NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`ID`)
);

# INSERT INTO ROLE (name) VALUE ('ADMIN');
# INSERT INTO ROLE (name) VALUE ('USER');

# INSERT INTO USER (ID, username, password, salt, email, createTime)
#   value(1, 'root', 'root', 'root', 'root@root.com', NOW())
CREATE DATABASE theRichCity CHARACTER SET = gb2312;

CREATE TABLE theRichCity.t_user (
	uuid UNSIGNED BIGINT PRIMARY KEY,
	nme VARCHAR(20) NOT NULL UNIQUE,
	eml VARCHAR(30) NOT NULL UNIQUE,
	pwd VARCHAR(20) NOT NULL,
	rgst_dt DATETIME NOT NULL,
    lst_updt_tme TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE theRichCity.t_session (
	uuid CHAR(32) PRIMARY KEY,
	user_uuid UNSIGNED BIGINT FOREIGN KEY REFERENCES t_user.uuid,
	isOver boolean NOT NULL,
	strt_dt DATETIME NOT NULL,
    lst_updt_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

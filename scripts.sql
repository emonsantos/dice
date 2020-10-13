CREATE SCHEMA `dice` ;

CREATE TABLE `dice`.`dice` (
  `dice_id` INT NOT NULL AUTO_INCREMENT,
  `no_of_piece` INT NOT NULL,
  `no_of_side` INT NOT NULL,
  `no_of_rolls` INT NOT NULL,
  PRIMARY KEY (`dice_id`));

CREATE TABLE `dice`.`roll_sum` (
  `roll_sum_id` INT NOT NULL AUTO_INCREMENT,
  `dice_id` INT NOT NULL,
  `side_sum` INT NOT NULL,
  `total_roll` INT NOT NULL,
  PRIMARY KEY (`roll_sum_id`),
  FOREIGN KEY (dice_id) REFERENCES dice(dice_id));

CREATE OR REPLACE
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `dice_side_distribution` AS
    SELECT 
        UUID() as `id`,
		`a`.`no_of_piece` AS `no_of_piece`,
        `a`.`no_of_side` AS `no_of_side`,
        `b`.`side_sum` AS `side_sum`,
        ((SUM(`b`.`total_roll`) / (SELECT 
                SUM(`d`.`total_roll`)
            FROM
                (`dice` `c`
                JOIN `roll_sum` `d`)
            WHERE
                ((`c`.`dice_id` = `d`.`dice_id`)
                    AND (`c`.`no_of_side` = `a`.`no_of_side`)
                    AND (`c`.`no_of_side` = `a`.`no_of_side`)))) * 100) AS `distribution`
    FROM
        (`dice` `a`
        JOIN `roll_sum` `b`)
    WHERE
        (`a`.`dice_id` = `b`.`dice_id`)
    GROUP BY `a`.`no_of_piece`, `a`.`no_of_side` , `b`.`side_sum`
    ORDER BY `a`.`no_of_piece`, `a`.`no_of_side` , `b`.`side_sum`;
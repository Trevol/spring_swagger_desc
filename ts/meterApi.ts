/* eslint-disable */
/* tslint:disable */
/*
 * ---------------------------------------------------------------
 * ## THIS FILE WAS GENERATED VIA SWAGGER-TYPESCRIPT-API        ##
 * ##                                                           ##
 * ## AUTHOR: acacode                                           ##
 * ## SOURCE: https://github.com/acacode/swagger-typescript-api ##
 * ---------------------------------------------------------------
 */

export type Entity1 = IEntity & { prop1: string; type: "Entity1" | "Entity2" };

export type Entity2 = IEntity & { prop1: string; prop2: number; type: "Entity1" | "Entity2" };

export interface IEntity {
  prop1: string;
  type: "Entity1" | "Entity2";
}

export interface Meter {
  abc: "A" | "B" | "C";

  /** @format date-time */
  created: string;
  dce: "D" | "C" | "E";
  entities: IEntity[];
  entitiesMap: Record<string, IEntity>;
  entitiesSet: IEntity[];
  entity: IEntity;
  id: string;
  readings: Reading[];
  readingsMap: Record<string, Reading>;
  readingsSet: Reading[];
  serial: string;
  you: "Y" | "U" | "O";
}

export interface Reading {
  /** @format double */
  value: number;
}

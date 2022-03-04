import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity('request')
export class StoreRequestEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({
    type: 'text',
  })
  request: string;

  @Column({
    type: 'text',
  })
  response: string;
}

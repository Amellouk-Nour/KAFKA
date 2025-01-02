import express, { Request, Response } from 'express';

interface EntityA {
  id: number;
  name: string;
  // ajoutez d'autres attributs selon les besoins
}

const app = express();
const port = 3000;

app.use(express.json());

app.get('/', (req: Request, res: Response) => {
  res.send('Hello World with TypeScript!');
});

app.post('/entityA', (req: Request, res: Response) => {
  const entity: EntityA = req.body;
  console.log(entity); // Traitez votre entité A
  res.status(201).send(entity);
});

app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});

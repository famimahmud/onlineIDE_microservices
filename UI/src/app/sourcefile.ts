export class SourceFile {
  id: number;
  name: string;
  sourceCode: string;


  constructor(id: number, name: string, sourceCode: string) {
    this.id = id;
    this.name = name;
    this.sourceCode = sourceCode;
  }
}

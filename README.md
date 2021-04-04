# Rich rail

Een applicatie waarmee treinen en de trein componenten mee beheert kunnen worden.

## API

Hierna volgt de API met alle endpoints waarmee de verschillende service aangesproken kunnen worden.

### Train

- Haal een lijst op van alle treinen:
  ```
  GET ./trains
  ```
- Laad een specifiek trein object met het "id" attribuut:
  ```
  GET ./train/{id}
  ```
- Maak een nieuwe trein aan:
  ```
  POST ./train
  Content-Type: application/json
  ---
  {
    "title": <string>
  }
  ```
- Verwijder een trein object met het "id" attribuut:
  ```
  DELETE ./train/{id}
  ```
  
### Component

- Maak een nieuw component aan:
  ```
  POST ./component
  Content-Type: application/json
  ---
  {
    "spot": <integer>,
    "train_id": <integer>,
    "type_id": <integer>
  }
  ```
- Verwijder (of ontkoppel) een bepaald component object met het "id" attribuut:
  ```
  DELETE ./component/{id}
  ```
- Koppel/wissel een bepaald component object met een bepaalde trein:
  ```
  PATCH ./component/{componentId}/train/{trainId}
  ```

### Type

- Maak een nieuw type aan:
  ```
  POST ./type
  Content-Type: application/json
  ---
  {
    "title": <string>
  }
  ```

### Type Attribute

- Maak een nieuw type attribuut aan:
  ```
  POST ./type-attribute
  Content-Type: application/json
  ---
  {
    "value": <string>,
    "key_id": <integer>,
    "type_id": <integer>
  }
  ```
### Type Attribute Key

- Maak een nieuw type attribuut sleutel aan:
  ```
  POST ./type-attribute-key
  Content-Type: application/json
  ---
  {
    "title": <string>
  }
  ```

## Functionaliteiten

- [x] Treinen kunnen in verschillende interfaces getoond worden. Bijvoorbeeld in een GUI en/of CLI.
- [x] Logs kunnen op verschillende manieren weg worden geschreven. Bijvoorbeeld naar een bestand en/of naar een externe service.
- [x] Nieuwe treinen toevoegen.
- [x] Een trein weergeven.
- [x] Een trein inladen.
- [x] Bestaande treinen verwijderen.
- [x] Een nieuw component type toevoegen.
- [x] Een nieuw component aanmaken op basis van een bepaald component type.
- [x] Een component kan gekoppeld worden aan een trein.
- [x] Een component kan worden losgekoppeld van een trein.
- [x] Bij elke handeling moeten logs getoond kunnen worden.
- [x] De data wordt gepersisteerd. 

## Klassendiagram

In figuur 1 is een simpele versie van het klassendiagram van de applicatie weergeven.

![figuur 1](./docs/assets/simpel-klassendiagram.svg)

_figuur 1: Een simpele versie van het klassendiagram_

<details><summary>Bekijk de broncode van figuur 1</summary>
<p>
  
```plantuml:simpel-klassendiagram
skinparam monochrome reverse

class Train {
  - title: string
  + getTitle(): string
  + getComponents(): Components[]
  + addComponent(Component c): void
  + removeComponent(Component c): void
}

class Type {
  - title: string
  - numberOfSeats: int
  - payloadCapacity: int
  + getTitle(): string
  + getComponents(): Component[]
  + addComponent(Component c): void
  + removeComponent(Component c): void
  + getAttributes(): TypeAttribute[]
  + addAttribute(TypeAttribute c): void
  + removeAttribute(TypeAttribute c): void
}

class TypeAttribute {
  - value: string
  - type: Type
  - key: TypeAttributeKey
  + getValue(): string
  + getType(): Type
  + getKey(): TypeAttributeKey
}

class TypeAttributeKey {
  - title: string
  - attributes: Attributes[]
  + getTitle(): string
  + getAttributes(): Attributes[]
}

class Component {
  - spot: int
  + getSpot(): int
  + getTrain(): Train
  + setTrain(): Train
  + getType(): Type
}

Train --> Component: - components: Components[]
Component --> Type: - type: Type
Type --> TypeAttribute: - attributes: Attributes[]
TypeAttributeKey --> TypeAttribute: - attributes: Attributes[]
```

</p>
</details>

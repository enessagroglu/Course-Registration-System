from abc import ABC, abstractmethod

def convert_to_english(s: str) -> str:
    # Create a dictionary of non-English characters and their English equivalents
    replacements = {
        'ş': 's',
        'Ş': 'S',
        'ğ': 'g',
        'Ğ': 'G',
        'ü': 'u',
        'Ü': 'U',
        'ö': 'o',
        'Ö': 'O',
        'ç': 'c',
        'Ç': 'C',
        'ı': 'i',
        'İ': 'I',
    }

    # Iterate through the string and replace each non-English character with its English equivalent
    result = ''
    for c in s:
        if c in replacements:
            result += replacements[c]
        else:
            result += c
    return result

class Person(ABC):
    def __init__(self, name: str, surname: str, id: str):
        self._name = name
        self._surname = surname
        self._id = id
        value = name+surname
        value = value.lower()
        self._email = convert_to_english(value)+"@marun.edu.tr"
        self._username = value
    
    

    # @abstractmethod
    # def get_full_name(self):
    #     pass
    
     # Getter and setter methods for the name attribute
    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value: str):
        self._name = value

    # Getter and setter methods for the surname attribute
    @property
    def surname(self):
        return self._surname

    @surname.setter
    def surname(self, value: str):
        self._surname = value

    # Getter and setter methods for the id attribute
    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value: str):
        self._id = value

    # Getter and setter methods for the emails attribute
    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, name: str, surname: str):
        value = name+surname
        convert_to_english(value)
        self._email = value+"@marun.edu.tr"
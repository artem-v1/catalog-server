-- Удаление внешнего ключа
ALTER TABLE offer_characteristic
DROP CONSTRAINT IF EXISTS fkhh4lxv9t851k1lanc04f935lu;

-- Удаление поля company_id
ALTER TABLE offer_characteristic
DROP COLUMN IF EXISTS company_id;
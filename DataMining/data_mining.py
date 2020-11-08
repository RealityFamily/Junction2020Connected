# -*- coding: utf-8 -*-
"""
  Прогнозирование данных.py
"""
import pandas as pd

from fbprophet import Prophet

import io

fileNameString = 'final_transaction_table.csv'
all_transactions = pd.read_csv(fileNameString)

all_transactions = all_transactions[all_transactions.amount < 0]
all_transactions.amount = -1 * all_transactions.amount

selected_transactions_data = all_transactions[['valueDate', 'amount', 'counterpartyAccountName']]

grouped_data_by_date_and_name = selected_transactions_data \
    .groupby(['valueDate', 'counterpartyAccountName']) \
    .agg({'amount': 'sum'}) \
    .reset_index()

grouped_data_by_date_and_name.valueDate = grouped_data_by_date_and_name.valueDate.apply(pd.to_datetime)

predictions = 4

final_dataset = grouped_data_by_date_and_name

all_names = final_dataset.drop_duplicates(subset='counterpartyAccountName', keep="last")
for name in all_names['counterpartyAccountName'].values:
    df_cert_name = final_dataset[final_dataset.counterpartyAccountName == name]
    if df_cert_name.shape[0] > 2:
        grouped_by_date_cert_name = final_dataset[final_dataset.counterpartyAccountName == name] \
            .groupby(['valueDate']) \
            .agg({'amount': 'sum'}) \
            .reset_index()
        train_dfr = grouped_by_date_cert_name[['valueDate', 'amount']]
        train_dfr.columns = ['ds', 'y']

        m = Prophet()
        m.fit(train_dfr)
        future = m.make_future_dataframe(periods=predictions)
        forecast = m.predict(future)

        temp = forecast[['ds', 'yhat']]
        temp = temp[temp.yhat > 0]
        predicted = temp[-predictions:]
        predicted.columns = ['valueDate', 'amount']

        predicted.insert(1, "counterpartyAccountName", [name] * predicted.shape[0])

        final_dataset = final_dataset.append(predicted, ignore_index=True)
final_dataset.valueDate = final_dataset.valueDate.apply(pd.to_datetime)
print(final_dataset)

unit uMercadoLivre;

interface
uses SysUtils;

type

  TMLOrder = class
    private
      fCurrency_id: String;
      fDate_created: TDateTime;
      fTags: array of string;
      fMediations: array of String;
      fId: integer;
      fHidden_for_seller: TDateTime;
      fStatus: String;
      fTotal_amount: integer;
      fDate_last_updated: TDateTime;
      fExpiration_date: TDateTime;
      fDate_closed: TDateTime;
      fComments: String;

    published
      property id: integer read fId write fId;
      property comments: String read fComments write fComments;
      property status: String read fStatus write fStatus;
      //property status_detail: array of TMLStatus_detail;
      property date_created: TDateTime read fDate_created write fDate_created;
      property date_closed: TDateTime read fDate_closed write fDate_closed;
      property expiration_date: TDateTime read fExpiration_date write fExpiration_date;
      property date_last_updated: TDateTime read fDate_last_updated write fDate_last_updated;
      property hidden_for_seller: TDateTime read fHidden_for_seller write fHidden_for_seller;
      property currency_id: String read fCurrency_id write fCurrency_id;
      //property order_items: array of TMLOrder_items;
      property total_amount: integer read fTotal_amount write fTotal_amount;
      property mediations: array of String read fMediations write fMediations;
      //property payments: array of TMLPayments;
      //property shipping: TMLShipping;
      //property buyer: TMLBuyer;
      //property seller: TMLSeller;
      //property feedback: TMLFeedback;
      property tags: array of string read fTags write fTags;



    public
      constructor create;
      destructor destroy;
      procedure clear;


  end;

implementation

{ TMLOrder }

procedure TMLOrder.clear;
begin
  fCurrency_id := '';
  FreeAndNil(fDate_created);
  fTags := '';
  fMediations := '';
  fId := 0;
  fHidden_for_seller := false;
  fStatus := '';
  fTotal_amount := 0;
  FreeAndNil(fDate_last_updated);
  FreeAndNil(fExpiration_date);
  FreeAndNil(fDate_closed);
  fComments := '';
  //adicionar composições;
end;

constructor TMLOrder.create;
begin
  inherited;
  clear;
end;

destructor TMLOrder.destroy;
begin
  clear;
  inherited;
end;

end.
